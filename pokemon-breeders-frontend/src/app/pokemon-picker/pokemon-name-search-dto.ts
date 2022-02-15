
export class PokemonNameSearchDTO {

    constructor(name : string, id : number, genus: string, identifierName : string){
        this.name = name;
        this.id = id;
        this.genus = genus;
        this.identifierName = identifierName;
    }

    name!: string;
    id!: number;
    genus: string | undefined;
    identifierName!: string;

}