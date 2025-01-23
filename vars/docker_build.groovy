def call(String image_name){
  docker build -t "${image_name} ."
}
