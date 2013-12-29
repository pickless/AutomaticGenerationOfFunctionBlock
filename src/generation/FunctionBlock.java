package generation;

import com.nomagic.magicdraw.uml.symbols.DiagramPresentationElement;

/**
 * Created by XJ on 13-12-30.
 */
public class FunctionBlock {
    private String name;
    private DiagramPresentationElement ecc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DiagramPresentationElement getEcc() {
        return ecc;
    }

    public void setEcc(DiagramPresentationElement ecc) {
        this.ecc = ecc;
    }
}
