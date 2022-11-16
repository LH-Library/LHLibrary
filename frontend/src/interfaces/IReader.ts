import IAddress from "./IAddress";
import IPerson from "./IPerson";

export default interface IReader extends IPerson{
    cpf: string,
    telefone: string,
    endereco: IAddress
}