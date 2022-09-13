package com.vdcom.vdcomtest.entity.utils;

import com.vdcom.vdcomtest.entity.Account;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSVHelper {
    private static final String type = "text/csv";
    private static final String[] headers = {"id", "name", "password"};

    public static boolean hasCSVFormat(MultipartFile file) {
        return type.equals(file.getContentType());
    }

    public static List<Account> csvToPersons(InputStream file) {
        if (file == null) return Collections.emptyList();
        try {
            Reader fileReader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));
            List<Account> accounts = new ArrayList<>();
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withHeader(headers)
                    .withFirstRecordAsHeader()
                    .parse(fileReader);
            for (CSVRecord record : records) {
                String stringId = record.get(headers[0]);
                Long id = (StringUtils.hasText(stringId)) ? Long.parseLong(stringId) : null;
                String name = record.get(headers[1]);
                String password = record.get(headers[2]);
                Account account = new Account();
                if (id != null) {
                    account.setId(id);
                }
                account.setName(name);
                account.setPassword(password);
                accounts.add(account);
            }
            return accounts;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}