pipeline {
    agent any
    
    stages{
        stage("Code"){
            steps{
                echo "cloning code from github"
                git branch: 'main', url: 'https://github.com/Neeraj-2806/django-notes-app.git'
                
            }
            
        }
        stage("Build"){
            steps{
                echo "Building the code "
                sh 'docker build -t notes-app .'
            }
            
        }
        stage("Push to Docker Hub"){
            steps{
                echo "pushing the image to docker hub"
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'dockerPass', usernameVariable: 'dockerUser')]){
                sh 'docker image tag notes-app ${dockerUser}/my-note-app:latest'
                sh "docker login -u ${dockerUser} -p ${dockerPass}"
                sh "docker push ${dockerUser}/my-note-app:latest"
                }
                
            }
            
        }
        stage("Deploying the app"){
            steps{
                echo "deploying the app"
                sh 'docker-compose down && docker-compose up -d'
                
            }
            
        }
    }
}
