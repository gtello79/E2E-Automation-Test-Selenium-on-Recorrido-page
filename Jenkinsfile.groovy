pipeline{
    agent any

    stages{
        stage('Compile Stage'){
            steps{
                withMaven('manven_3_9_5'){
                    sh'mvn clean compile'
                }
            }
        }

        stage('Test Stage'){
            steps{
                withMaven('manven_3_9_5'){
                    sh'mvn test'
                }
            }
        }

        stage('Cucumber Reports'){
            steps{
                cucumber buildStatus: 'UNSTABLE', 
                fileIncludePattern: '**/target/cucumber-reports/*.json', 
                jsonReportDirectory: 'target/cucumber-reports',
            }
        }
    }
}