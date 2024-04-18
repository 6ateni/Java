package homework.lesson_2;

public class Test_1 {

    // Сформируйте SQL-запрос
    // Дана строка sql-запроса:
    // select * from students where "
    // Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные
    // (параметры) для фильтрации приведены в виде json-строки в примере ниже. Если
    // значение null, то параметр не должен попадать в запрос.
    // Напишите свой код в методе answer класса Answer. Метод answer принимает на
    // вход два параметра:
    // String QUERY - начало SQL-запроса String PARAMS - JSON с параметрами

    // Пример: Строка sql-запроса:
    // select * from students where
    // Параметры для фильтрации:
    // {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
    // Результат:
    // select * from students where name='Ivanov' and country='Russia' and
    // city='Moscow'

    class Answer {
        public StringBuilder answer(String QUERY, String PARAMS) {
            // Напишите свое решение ниже
            String prepare = PARAMS.replace("{", "").replace("}", "").replace("\"", "");

            String name = prepare.split(",")[0].split(":")[1];
            String country = prepare.split(",")[1].split(":")[1];
            String city = prepare.split(",")[2].split(":")[1];
            String age = prepare.split(",")[3].split(":")[1];

            StringBuilder res = new StringBuilder(QUERY);
            if (!name.equals("null")) {
                res.append("name=").append("'").append(name).append("'");
            }
            if (!name.equals("null") && !country.equals("null")) {
                res.append(" and ");
            }
            if (!country.equals("null")) {
                res.append("country=").append("'").append(country).append("'");
            }
            if (!city.equals("null")) {
                res.append(" and ");
            }
            if (!city.equals("null")) {
                res.append("city=").append("'").append(city).append("'");
            }
            if (!age.strip().equals("null")) {
                res.append(" and ");
            }
            if (!age.strip().equals("null")) {
                res.append("age=").append("'").append(age).append("'");
            }
            return res;
        }
    }

    // Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
    public class Printer {
        public static void main(String[] args) {
            String QUERY = "";
            String PARAMS = "";

            if (args.length == 0) {
                // При отправке кода на Выполнение, вы можете варьировать эти параметры
                QUERY = "select * from students where ";
                PARAMS = "{\"name\":\"null\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
            } else {
                QUERY = args[0];
                PARAMS = args[1];
            }

            Answer ans = new Test_1().new Answer();
            System.out.println(ans.answer(QUERY, PARAMS));
        }
    }
}