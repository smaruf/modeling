package modeling.repository;

import modeling.model.Idea;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author maruf
 * @since 10/29/17
 */
public enum IdeaFileRepository {
    STORE;
    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private List<Idea> ideaList;
}
