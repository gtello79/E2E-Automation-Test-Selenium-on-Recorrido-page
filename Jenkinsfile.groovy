pipeline{
    agent any

    stages{
        stage('Compile Stage'){
            steps{
                def mvnHome = tool 'manven_3_9_5', type: 'maven'
                withEnv(['M2_HOME=${mvnHome}', 'M2=${mvnHome}/bin']){
                    sh 'mvn -version'
                    sh 'mvn compile'
                }
            }
        }

        stage('Test Stage'){
            steps{
                withEnv(['M2_HOME=${mvnHome}', 'M2=${mvnHome}/bin']){
                    sh 'mvn test'
                }
            }
        }

    }
}