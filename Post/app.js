const express = require('express');
// connect mysql
const db = require('./models/databaseConnection.js');

const hbs = require('express-handlebars');
const app = express();
const PORT = 3000;

// template engine
app.engine('handlebars',hbs());
app.set('view engine','handlebars');
// config method post
app.use(express.urlencoded({extended : true}));

app.get('/',(req,res)=>{
  res.render('home');
})

app.get('/user',(req,res)=>{
  // const g = db.getAll();
  db.getAll().then(
      (data)=>{
        res.render("user",{rs : data});
      }
  ).catch(
      (err)=>{
        res.render("home");
      }
  )
});
app.get('/insert',(req,res)=>{
  res.render("form");
});
app.post('/insert',(req,res)=>{
  let name = req.body.name;
  let phone = req.body.phone;
  let code = req.body.code;
  db.insert(name,phone,code).then(
      (data)=>{
          res.redirect('/user');
      }
  ).catch(
      (err)=>{
        res.send(err);
      }
  )
})
app.get('/delete',(req,res)=>{
  let id = req.query.id
  db.del(id).then(
      (data)=>{
        res.redirect('/user');
      }
  ).catch(
      (err)=>{
        res.send(err);
      }
  )
})
app.listen(PORT,()=> console.log(`http://localhost:${PORT}`));