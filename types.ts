import { v4 } from "https://deno.land/std@0.148.0/uuid/mod.ts";

//export 외부에서 import로 접근 가능 
export class Book {
    id!: string;
    title!: string;
    author!: string;

    constructor() {}

    static generate(title: string, author: string): Book { // * 인자를 이렇게 하나씩 받아도 되고, input: DTO로 한번에 다 받아도 된다.
        const instance: Book = new Book();
        instance.id = v4.generate(); // * id가 uuid v4로 자동으로 만들어진다는 사실은 이 Domain Entity가 가지고 있는 특성이다.
        instance.title = title;
        instance.author = author;
        return instance;
    }
}

//todo 인터페이스 
export interface TodoList {
    id: string;
    title: string;
    date: string;
}