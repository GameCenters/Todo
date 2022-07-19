// deno-lint-ignore-file
import {Application,Context,Router} from "https://deno.land/x/oak@v10.6.0/mod.ts"
import router from "./routes.ts";

const app = new Application();

app.use(router.routes());
app.use(router.allowedMethods());

//포트 번호는 5005으로 설정 
await app.listen({port:5005});

