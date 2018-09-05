import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class Oblig1Test {
    @org.junit.Test
    public void maks() throws Exception {
    }

    @org.junit.Test
    public void ombytting() throws Exception {
    }

    @org.junit.Test
    public void antallUlikeSortert() throws Exception {
    }

    @org.junit.Test
    public void sjekkGyldigFormat() throws Exception {
    }

    @org.junit.Test
    public void bytt() throws Exception {
    }

    @org.junit.Test
    public void maksIndex() throws Exception {
    }

    @org.junit.Test
    public void minIndex() throws Exception {
    }

    @org.junit.Test
    public void randPerm() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Oblig1.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
