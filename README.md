# Exercício de fixação

Fazer um programa para ler os dados (nome, email e salário)
de funcionários a partir de um arquivo em formato .csv.

Em seguida mostrar, em ordem alfabética, o email dos
funcionários cujo salário seja superior a um dado valor
fornecido pelo usuário.

Mostrar também a soma dos salários dos funcionários cujo
nome começa com a letra 'M'.

![Employee](pictures/Employee.png)

**Input file:**

```
Maria,maria@gmail.com,3200.00
Alex,alex@gmail.com,1900.00
Marco,marco@gmail.com,1700.00
Bob,bob@gmail.com,3500.00
Anna,anna@gmail.com,2800.00
```

**Execution:**

```
Enter full file path: in.txt
Enter salary: 2000.00
Email of people whose salary is more than 2000.00:
anna@gmail.com
bob@gmail.com
maria@gmail.com
Sum of salary of people whose name starts with 'M': 4900.00
```