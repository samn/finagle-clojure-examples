namespace java dog_breed_info.thrift

struct Request {
    1: string name
}

struct Response {
    1: string name
    2: bool beautiful
}

service DogBreedInfo {
    Response isBreedBeautiful(1: Request request)
}
