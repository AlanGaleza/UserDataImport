package com.dataimport;

import com.dataimport.Exceptions.FileReaderException;
import com.dataimport.service.FileRead;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileReaderTests {

    @Autowired
    private FileRead fileRead;

    @Test
    public void shouldReadFile() throws FileReaderException, IOException {
        //given
        String path = new ClassPathResource("file/personData.txt").getFile().toString();
        Path path1 = Paths.get(path);

        //when && then
        fileRead.readFile(path);
        assertThat(Files.exists(path1)).isTrue();
    }
}
