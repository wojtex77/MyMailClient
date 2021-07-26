package pl.wojciechsiwek;

import javafx.scene.control.TreeItem;
import pl.wojciechsiwek.controller.services.FetchFoldersService;
import pl.wojciechsiwek.model.EmailAccount;
import pl.wojciechsiwek.model.EmailTreeItem;

public class EmailManager {

    //Folders handling:
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<>("");

    public EmailTreeItem<String> getFoldersRoot(){
        return foldersRoot;
    }
    public void addEmailAccount(EmailAccount emailAccount){
        EmailTreeItem<String> treeItem = new EmailTreeItem<>(emailAccount.getAddress());
        FetchFoldersService fetchFoldersService = new FetchFoldersService(emailAccount.getStore(), treeItem);
        fetchFoldersService.start();
        foldersRoot.getChildren().add(treeItem);
    }
}
