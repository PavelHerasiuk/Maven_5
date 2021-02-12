package by.com.task3;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * Описание: SuffixingApp With Maven
 * Используйте maven для создания и управления простой программой Java с зависимостями.
 * Спецификация приложения:
 * Это приложение с суффиксами - небольшое Java-приложение, которое обращается к файлу конфигурации,
 * переименовывает набор файлов и переименовывает их, добавляя суффикс, указанный в той же конфигурации.
 * Детали:
 * Приложение должно прочитать файл конфигурации при запуске
 * Затем он должен убедиться, что все файлы из конфигурации существуют.
 * Затем он должен переименовать каждый файл, добавив суффикс из конфигурации к его имени
 * Он должен напечатать результаты переименования, например:   old_name -> new_name.
 * Шаги:
 * Создайте проект maven и укажите его настройки GAV, кодировку, уровень языка и т. Д.
 * Добавьте зависимость к некоторой библиотеке для чтения и анализа файлов JSON. (например, GSON)
 * Напишите код, реализующий спецификацию приложения.
 * Настройте проект maven для создания работающего jar-файла,содержащего приложение и его зависимости.
 */
public class Launcher {

    public static void main(String[] args) {
        new Launcher().asProperties().forEach( (key, value) -> System.out.println(key + ": " + value));

        System.out.println(new Launcher().asJson());

        //В этот момент ты знаешь где файлы, какие нужны файлы и как их переименовать
    }

    private Properties asProperties() {
        try (InputStream inputStream = Launcher.class.getClassLoader().getResourceAsStream("config.properties")) {

            Properties properties = new Properties();
            properties.load(inputStream);

            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Configuration asJson() {
        try (InputStream inputStream = Launcher.class.getClassLoader().getResourceAsStream("config.json")) {

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(inputStream.readAllBytes(), Configuration.class);

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}