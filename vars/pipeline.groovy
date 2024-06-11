node {

    env.PATH = "${tool 'Maven'}/bin:${env.PATH}"

    def MAX_RUNS = 5
    def runNumber = 1
    def scope = '${TESTS_SCOPE}'
    def threads = '${THREADS_COUNT}'

    echo "The Regression has been started!"
    stage('Checkout') {
        checkout([$class: 'GitSCM',
                  branches: [[name: '${BRANCH}']],
                  userRemoteConfigs: [[url: '${GIT_URL}']]])
    }
    stage('Smoke') {
        sh "mvn clean test site -Durl=${TARGET_URL} -Dbrowser=${BROWSER_NAME} -Dversion=${BROWSER_VERSION} -Dtest=ExampleTest -Dtimeout=${TIMEOUT} -DthreadCount=1"
    }
    stage('Regression') {
        for (int run in 1..MAX_RUNS) {
            stage("Execution #${run}") {
                try {
                    sh "mvn clean test site -Durl=${TARGET_URL} -Dbrowser=${BROWSER_NAME} -Dversion=${BROWSER_VERSION} -Dtest=${scope} -Dtimeout=${TIMEOUT} -DthreadCount=${threads}"
                } finally {
                    scope = "" //getFailedTests()
                    if (scope == null || scope == "") {
                        //All tests passed - moving to the next stage
                        return
                    } else {
                        //Some tests failed - reducing the number of threads and re-running with the updated scope (the failed tests only)
                        threads = reduceThreads(threads)
                    }
                }
            }
        }
    }
    post {
        always {
            stage('Report') {
                echo "The Report has been created here!"
            }
            echo "The Regression has been completed!\nSee results here: ${RUN_DISPLAY_URL}"
        }
    }
}