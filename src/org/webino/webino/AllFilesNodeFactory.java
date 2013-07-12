package org.webino.webino;

import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.NodeFactory;
import org.netbeans.spi.project.ui.support.NodeFactorySupport;
import org.netbeans.spi.project.ui.support.NodeList;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.util.Exceptions;

@NodeFactory.Registration(projectType = "org-netbeans-modules-php-project")
public class AllFilesNodeFactory implements NodeFactory {

    @Override
    public NodeList createNodes(Project project) {

        try {
            AllFilesNode nd = new AllFilesNode(project);
            return NodeFactorySupport.fixedNodeList(nd);
        } catch (DataObjectNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }

        return NodeFactorySupport.fixedNodeList();

    }

}
