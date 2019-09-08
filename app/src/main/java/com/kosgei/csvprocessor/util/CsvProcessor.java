package com.kosgei.csvprocessor.util;

import com.kosgei.csvprocessor.models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvProcessor {

    public List<User> getUsers(File file)
    {
        List<User> users = new ArrayList<>();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int iteration = 0;


            while ((line = br.readLine()) !=null) {
                User user = new User();
                //skip the first row since its a header
                if(iteration == 0) {
                    iteration++;
                    continue;
                }
                //separator
                String[] tokens = line.split(",");

                user.setFullNames(tokens[0]);
                user.setDateOfBirth(simpleDateFormat.parse(tokens[1]));
                user.setHeight(Double.parseDouble(tokens[2]));
                user.setActive(Boolean.parseBoolean(tokens[3]));
                user.setRoles(new ArrayList<>(Arrays.asList(tokens[4].split(","))));
                users.add(user);
            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return users;
    }
}
