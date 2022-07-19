import { Client } from "https://deno.land/x/mysql/mod.ts";

const client = await new Client().connect({
  hostname: "127.0.0.1",
  username: "root",
  db: "todo",
  poolSize: 3,
  password: "6389",
});

// //INSETE
// let result = await client.execute(`INSERT INTO todolist(name) values(?)`, [
//     'b',
//   ]);
//   console.log(result);

//SELECT
const users = await client.query(`select * from todolist`);
const queryWithParams = await client.query(
    "select ? from ??",
    ["name", "todolist"],
);

console.log(users, queryWithParams);

export default client;