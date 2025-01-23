def call(String project_name, String dockerUser, String Imagetag){
  echo "pushing the image to docker hub"
      withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'dockerPass', usernameVariable: 'dockerUser')]){
         sh "docker image tag notes-app ${dockerUser}/${project_name}:${Imagetag}"
         sh "docker login -u ${dockerUser} -p ${dockerPass}"
         sh "docker push ${dockerUser}/${project_name}:${Imagetag}"
}
}

