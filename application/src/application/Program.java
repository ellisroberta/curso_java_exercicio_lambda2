package application;

import model.entities.Employee;

import java.io.BufferedReader; // Para ler o arquivo linha por linha
import java.io.FileReader; // Para abrir o arquivo
import java.io.IOException; // Para tratar exceções de I/O
import java.util.ArrayList; // Para usar ArrayList
import java.util.List; // Para usar List
import java.util.Locale; // Para definir a localidade
import java.util.Scanner; // Para entrada do usuário
import java.util.stream.Collectors; // Para usar operações de stream

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US); // Define a localidade para formato de moeda
        Scanner sc = new Scanner(System.in); // Cria um scanner para entrada do usuário

        // Solicita ao usuário o caminho do arquivo
        System.out.print("Enter full file path: ");
        String path = sc.nextLine(); // Lê o caminho do arquivo

        try (BufferedReader br = new BufferedReader(new FileReader(path))) { // Tenta abrir o arquivo para leitura
            List<Employee> list = new ArrayList<>(); // Cria uma lista para armazenar os funcionários

            String line = br.readLine(); // Lê a primeira linha do arquivo
            while (line != null) { // Enquanto houver linhas no arquivo
                String[] fields = line.split(","); // Divide a linha pelo delimitador vírgula
                // Adiciona um novo funcionário à lista
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine(); // Lê a próxima linha
            }
            // Solicita ao usuário um valor de salário
            System.out.print("Enter salary: ");
            double salary = sc.nextDouble(); // Lê o valor do salário

            // Filtra os emails dos funcionários com salário acima do valor fornecido e os ordena
            List<String> emails = list.stream()
                    .filter(x -> x.getSalary() > salary) // Filtra funcionários com salário acima do informado
                    .map(x -> x.getEmail()) // Obtém os emails dos funcionários filtrados; a expressão lambda pode ser substituída pela referência de método Employee::getEmail
                    .sorted() // Ordena os emails em ordem alfabética
                    .collect(Collectors.toList()); // Coleta os resultados em uma lista; 'collect(toList())' pode ser substituído por 'toList()'

            // Exibe os emails dos funcionários que ganham mais do que o valor fornecido
            System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary) + ":");
            emails.forEach(System.out::println); // Exibe cada email na lista

            // Calcula a soma dos salários dos funcionários cujo nome começa com a letra 'M'
            double sum = list.stream()
                    .filter(x -> x.getName().charAt(0) == 'M') // Filtra funcionários cujo nome começa com 'M'; a expressão pode ser melhorada para usar startsWith("M")
                    .map(x -> x.getSalary()) // Obtém os salários dos funcionários filtrados; a expressão lambda pode ser substituída pela referência de método Employee::getSalary
                    .reduce(0.0, (x, y) -> x + y); // Soma os salários filtrados

            // Exibe a soma dos salários dos funcionários cujo nome começa com 'M'
            System.out.println("Sum of salary from people whose name starts with 'M': " + String.format("%.2f", sum));

        } catch (IOException e) { // Trata exceções de I/O
            System.out.println("Error: " + e.getMessage()); // Exibe mensagem de erro
        }
        sc.close(); // Fecha o scanner
    }
}