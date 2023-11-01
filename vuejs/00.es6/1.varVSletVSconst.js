// 1. 선언 및 할당.
// var : function scope
var x = 10;
console.log(x);
var x = 20;
console.log(x);

// let : block scope
// let 예약어는 한번 선언한 똑같은 변수를 재선언할 수 없다.
let y = 10;
console.log(y);
// let y = 20; //Cannot redeclare block-scoped variable 'y'

// const : 상수
// const 예약어는 한번 할당한 값을 변경할 수 없다.
const z = 10;
// z = 20; // Assignment to constant variable

// 단 객체 { } 또는 배열 [ ]로 선언했을 경우 객체의 속성과 배열의 요소는 변경 가능.
const ssafy = {
  area: "서울",
  class: 10,
};
console.log(ssafy.area);
ssafy.area = "부울경";
console.log(ssafy.area);

// const btnRegister = document.querySelector("#btn-register");
// const btnRegister = document.querySelector("#btn-list");

const num = [];
console.log(num);
num.push(10);
console.log(num);

// 2. Scope (범위)
// var의 유효범위 : 함수레벨 스코프(function-level scope)
var a = 100;
function varPrint() {
  var a = 200;
  console.log(a);
  if (true) {
    var a = 300;
    console.log(a);
    a = 400;
  }
  console.log(a);
}
varPrint();
console.log(a);

console.log("-----------------------");

// let의 유효범위 : 블록레벨 스코프(block-level scope)
let b = 100;
function varPrint() {
  let b = 200;
  console.log(b);
  if (true) {
    let b = 300;
    console.log(b);
    b = 400;
  }
  console.log(b);
}
varPrint();
console.log(b);

// for문
var i = 10;
for (var i = 0; i < 5; i++) console.log(i);
console.log("i = " + i);

// 해결
var j = 10;
for (let j = 0; j < 5; j++) console.log(j);
console.log("j = " + j);

// var VS let Scope Test
function varTest() {
  var x = 11;
  if (true) {
    var x = 99; // same variable!
    console.log(x); // 99
  }
  console.log(x); // 99
}

function letTest() {
  let x = 11;
  if (true) {
    let x = 99; // different variable!
    console.log(x); // 99
  }
  console.log(x); // 11
}
function varTest() {
  if (true) {
    var x = 99;
    console.log(x); // 99
  }
  console.log(x); // 99
}

function varTest() {
  let x = 99;
  if (true) {
    console.log(x); // 99
  }
  console.log(x); // 99
}

function varTest() {
  if (true) {
    let x = 99;
    console.log(x); // 99
  }
  console.log(x); // Uncaught ReferenceError: x is not defined
}
