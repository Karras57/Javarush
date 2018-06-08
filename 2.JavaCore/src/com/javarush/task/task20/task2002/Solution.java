package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User user1 = new User();
            user1.setFirstName("vanya");
            user1.setLastName("Ivanov");
            user1.setBirthDate(new Date(1990, 5,22));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user1);

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush.equals(loadedObject)){
                System.out.println("equals");
            }else {
                System.out.println("not equals");
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            StringBuilder sb = new StringBuilder();
            sb.append("JavaRush").append(System.lineSeparator());
         //   SimpleDateFormat dateFormat = new SimpleDateFormat("dd.M.yyyy");
            for (User user : users) {
                sb.append("nextUser").append("\n");
                sb.append(user.getFirstName()).append("\n");
                sb.append(user.getLastName()).append("\n");
                //sb.append(dateFormat.format(user.getBirthDate())).append("\n");
                sb.append(user.getBirthDate().getTime()).append("\n");
                sb.append(user.isMale()?1:0).append("\n");
                sb.append(user.getCountry().name()).append("\n");
            }
            outputStream.write(sb.toString().getBytes());
            outputStream.flush();
            //outputStream.write(("JavaRush"+ System.lineSeparator()).getBytes());


        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (!"JavaRush".equals(reader.readLine())) return;
           // SimpleDateFormat dateFormat = new SimpleDateFormat("dd.M.yyyy");
            while ("nextUser".equals(reader.readLine())){
                User user = new User();
                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());
              //  user.setBirthDate(dateFormat.parse(reader.readLine()));
                user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                user.setMale(reader.readLine().equals("1"));
                user.setCountry(User.Country.valueOf(reader.readLine()));
                users.add(user);

            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
