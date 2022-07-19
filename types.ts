//export 외부에서 import로 접근 가능 
export class Book {
    id: string;
    title: string;
    author: string;

    constructor(id:string,title:string,author:string){
        this.id = id;
        this.title = title;
        this.author = author;
    }
}

//todo 인터페이스 
export interface TodoList{
    id: string;
    title: string;
    date: string;
}