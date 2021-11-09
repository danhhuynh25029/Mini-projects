const mysql = require('mysql');

const db = mysql.createConnection({
  host : 'localhost',
  user : 'root',
  password : 'admin12345',
  database : 'EmployeeManager'
});
const getAll = ()=>{
  return new Promise(function(resolve,reject){
    const sql = "SELECT * FROM  employee";
    db.query(sql,(err,results)=>{
    if(err) reject(err);
    resolve(results);
    // db.release();
    });
  })
  // db.release();
}
const insert = (name,phone,code)=>{
  return new Promise(function(resolve,reject){
    const sql = `INSERT INTO employee(name,phone,code) VALUES('${name}','${phone}','${code}')`;
    db.query(sql,(err,results)=>{
      if(err) reject(err);
      resolve(results);
    })
  })
}
const del = (id)=>{
  return new Promise(function(resolve,reject){
    const sql = `DELETE FROM employee WHERE id=${id}`;
    db.query(sql,(err,results)=>{
      if(err) reject(err);
      resolve(results);
    })
  })
}
// var d = get();
// d.then(
//   (data)=>{
//     // console.log("promise");
//     console.log(data);
//   }
// ).catch(
//   (err)=>{
//     console.log(err);
//   }
// )
// insert("TT","1312414",313131).then(
//     (data)=>{
//       console.log("Insert success!");
//     }
// ).catch(
//     (err)=>{
//       console.log("Insert failed!");
//     }

// )
module.exports = {getAll,insert,del};