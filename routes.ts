// deno-lint-ignore-file
//Deno는 module을 URL주소를 통해서 사용가능 
import { Book, TodoList } from "./types.ts";
import { v4 } from "https://deno.land/std@0.148.0/uuid/mod.ts";
import { Context, Router } from "https://deno.land/x/oak@v10.6.0/mod.ts"
import { Status } from "https://deno.land/std@0.148.0/http/http_status.ts"

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

interface IBookRepository {
    findBook(conid: string, context: Context): void | undefined;
}

class BookRepository implements IBookRepository {
    findBook(conid: string, context: Context): void {
        const book: Book | undefined = books.find((b) => b.id === conid);
        if (book) {
            context.response.body = book;
            context.response.status = Status.OK;// 요청성공 
        }
        else {
            //id가 존재 하지않을경우 에러 코드와 내용을 전달 
            context.response.body = "책을 찾지못했습니다";
            context.response.status = Status.NotFound;// 요청 리소스를 찾을수 없다 (주로 리소스가 서버에 존재하지 않을때)
        }
    }
}

router.get('/', (context) => {
    context.response.body = "Hello World";
})
    .get("/books", (context) => {
        context.response.body = books;
    })

    //TodoList의 값을 보내줌 
    .get("/Todos", (context) => {
        context.response.body = todolist;
    })
    .post("/book", async (context) => {
        const body = await context.request.body();

        //만약 정보를 제공하지 않았다면 
        if (!context.request.hasBody) {

            //400번 에러를 보내줌 
            context.response.status = Status.BadRequest //클라이언트의 잘못된 요청으로 요청에 대해 처리불가 

            //body로 보낼 값 
            context.response.body = "데이터가 없습니다"
        }
        //정보를 제공 받았다면 
        else {

            //Book 객체를 선언하고 제공받은 정보(DTO)를 저장
            const book: Book = await body.value;
            //임의로 아이디를 생성
            book.id = v4.generate();
            //push작업으로 객체를books Array에 저장  
            books.push(book);
            context.response.status = Status.Created;//요청에 따라 리소스를 생성 완료 
            context.response.body = book;
        }
    })
    .get("/book/:id", async (context) => {
        const conid: string = context.params.id;
        const bookrepositroy = new BookRepository();
        bookrepositroy.findBook(conid, context);
    })

//라우터는 server에서 사용가능하도록 export로 설정 
export default router;
