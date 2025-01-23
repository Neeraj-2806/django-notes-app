def call (String url, String branch){
  echo "cloning from git hub"
  git url: "${url}", branch: "${branch}"
}
