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
    }
}