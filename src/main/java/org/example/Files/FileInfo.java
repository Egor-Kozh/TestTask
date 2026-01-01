package org.example.Files;

public class FileInfo {

    public static void printInfo() {
        System.out.println("=====INFORMATION=====");
        System.out.println("-i - информация о программе");
        System.out.println("-o - путь для результатов. -o /some/path");
        System.out.println("-p - задает префикс имен выходных файлов. -p result_");
        System.out.println("-a - можно задать режим добавления в существующие файлы (перезаписывывает файлы по умолчанию)");
        System.out.println("-s - краткая статистика (количество элементов)");
        System.out.println("-s - полная статистика (количество элементов, минимальное и максимальное значение, среднее и сумма)");
    }
}
