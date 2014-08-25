namespace java dog_shelter.thrift

struct DogInfo {
    1: string breed
    2: string name
    3: bool houseTrained
    4: bool beautiful
}

service DogShelter {
    void addDog(1: string breed 2: string name 3: bool houseTrained)
    list<DogInfo> listDogs()
}
