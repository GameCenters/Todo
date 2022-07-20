import { Database, Model, DataTypes } from "https://deno.land/x/denodb@v1.0.40/mod.ts";

const db = new Database('postgres', {
    host: "localhost",
    username: "root",
    password: "6389",
    database: "todo",
    port: 3306,
});

class User extends Model {
    static table = "user";
    static timestamps = true;
    static fields = {
        id: {
            primaryKey: true,
            autoIncrement: true
        },
        name: {
            type: DataTypes.STRING,
            unique: true,
            allowNull: false,
            length: 20
        },
    }
}

db.link([User]);

await db.sync({ drop: true });