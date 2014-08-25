namespace java dog_breed_info.thrift

struct BeautifulBreedRequest {
    1: string name
}

struct BeautifulBreedResponse {
    1: string name
    2: bool beautiful
}

service DogBreedInfo {
    BeautifulBreedResponse isBeautiful(1: BeautifulBreedRequest request)
}
