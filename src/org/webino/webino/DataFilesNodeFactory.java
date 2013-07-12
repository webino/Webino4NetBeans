package org.webino.webino;

import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.NodeFactory;
import org.netbeans.spi.project.ui.support.NodeFactorySupport;
import org.netbeans.spi.project.ui.support.NodeList;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.util.Exceptions;

@NodeFactory.Registration(projectType = "org-netbeans-modules-php-project")
public class DataFilesNodeFactory implements NodeFactory {

    @Override
    public NodeList createNodes(Project project) {

        //Optionally, only return a new node
        //if some item is in the project's lookup:
        FileObject item = project.getProjectDirectory().getFileObject("data");
        if (item != null) {
            try {
                DataFilesNode nd = new DataFilesNode(project);
                return NodeFactorySupport.fixedNodeList(nd);
            } catch (DataObjectNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }
        }

        //If the above try/catch fails, e.g.,
        //our item isn't in the lookup,
        //then return an empty list of nodes:
        return NodeFactorySupport.fixedNodeList();

    }

}