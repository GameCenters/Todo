// deno-lint-ignore-file
//Deno는 module을 URL주소를 통해서 사용가능 
import  { Router } from "https://deno.land/x/oak@v10.6.0/mod.ts"
import { v4 } from "https://deno.land/std@0.148.0/uuid/mod.ts";
import { Status } from "https://deno.land/std@0.148.0/http/http_status.ts"
import {Book,TodoList} from "./types.ts";

//Router 생성 
const router = new Router();

let books: Book[] = [
    {
        id: "1",
        title: "Book 1",
        author: "One",
    },
    {
        id: "2",
        title: "Book 2",
        author: "Two",
    },
    {
        id: "3",
        title: "Book 3",
        author: "Three",
    },
]

let todolist: TodoList[] = [
    {
        id: "1",
        title: "Todo List 만들기",
        date: "2022-07-19",
    },
]

router.get('/',(context) => {
    context.response.body = "Hello World";
})
    .get("/books",(context) =>{
        context.response.body = books;
    })

    //TodoList의 값을 보내줌 
    .get("/Todos",(context) =>{
        context.response.body = todolist;
    })
    .post("/book", async (context) =>{
        const body = await context.request.body();

        //만약 정보를 제공하지 않았다면 
        if(!context.request.hasBody){

            //400번 에러를 보내줌 
            context.response.status = Status.BadRequest

            //body로 보낼 값 
            context.response.body = "데이터가 없습니다"
        }
        else{
            //정보를 제공 받았다면 
            //임의로 아이디를 생성하고 제공받은 정보롤 book object를 만들어준다 
            const book: Book = await body.value;
            book.id = v4.generate();
            books.push(book);
            context.response.status = 201;
            context.response.body = book;
        }
    })
    .get("/book/:id",async(context) =>{
        const book:Book | undefined = books.find((b) => b.id === context.params.id);
        if(book){
            context.response.body = book;
            context.response.status = 200;
        }
        else{
            //id가 존재 하지않을경우 에러 코드와 내용을 전달 
            context.response.body = "책을 찾지못했습니다";
            context.response.status = 404;
        }
    })

    //라우터는 server에서 사용가능하도록 export로 설정 
    export default router;
