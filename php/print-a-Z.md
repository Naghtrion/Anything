```php
  // imprime da A a Z
  foreach(range('A', 'Z') as $letra) {
      print $letra;
  }

  // imprime de 0 a 9
  foreach(range(0, 9) as $numero) {
      print $numero;
  }

  // imprime de 0 a 1000 pulando de 100 em 100
  foreach(range(0, 1000, 100) as $numero) {
      print $numero;
  }
```
