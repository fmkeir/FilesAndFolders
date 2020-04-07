package com.codeclan.example.filesService.Components;

import com.codeclan.example.filesService.models.File;
import com.codeclan.example.filesService.models.Folder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.codeclan.example.filesService.repositories.FileRepository;
import com.codeclan.example.filesService.repositories.FolderRepository;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    FileRepository fileRepository;
    @Autowired
    FolderRepository folderRepository;

    public DataLoader() {}

    @Override
    public void run(ApplicationArguments args) throws Exception {
        fileRepository.deleteAll();
        folderRepository.deleteAll();

        Folder nonFiction = new Folder("Non-Fiction");
        folderRepository.save(nonFiction);

        Folder invoices = new Folder("Invoices");
        folderRepository.save(invoices);

        File file1 = new File("On the Origin of Bananas", "txt", 78, nonFiction);
        fileRepository.save(file1);

        File file2 = new File("Romulus and Remus: The Origin of Reme", "pdf", 567, nonFiction);
        fileRepository.save(file2);

        File file3 = new File("Deep Work", "epub", 430, nonFiction);
        fileRepository.save(file3);

        File file4 = new File("Jan19", "pdf", 43, invoices);
        fileRepository.save(file4);

        File file5 = new File("Feb19", "pdf", 43, invoices);
        fileRepository.save(file5);

        File file6 = new File("Mar19", "pdf", 43, invoices);
        fileRepository.save(file6);
    }
}
