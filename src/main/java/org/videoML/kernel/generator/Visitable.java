package org.videoML.kernel.generator;

public interface Visitable {
    void accept(Visitor visitor);
}
