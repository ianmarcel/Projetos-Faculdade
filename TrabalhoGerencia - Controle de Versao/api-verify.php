<?php

if($_SERVER['REQUEST_METHOD'] == 'POST' && $_SERVER['REQUEST_URI'] == 'verify') {
  $data = json_decode(file_get_contents('php://input'));
  response($data);
}

function response($data_response){
  header("Content-type: application/json");
  echo json_encode($data_response);
}
