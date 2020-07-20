import { createServer } from "http";
import { readFile } from "fs";

createServer((req, res)=>{
    readFile("index.html", (err,data)=>{
        res.writeHead(200, {"content-type": "text/html"});
        res.write(data);
        return res.end();
    });
    
}).listen(8080);