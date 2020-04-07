package controllers;

import models.Folder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import repositories.FolderRepository;

import java.util.List;

@RestController
public class FolderController {
    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value="/files")
    public ResponseEntity<List<Folder>> getAllFiles(){
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }
}