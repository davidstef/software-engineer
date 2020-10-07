import java.util.ArrayList;

class ImageEditor {
    public CompoundGraphic all;

    public void load() {
        all = new CompoundGraphic();
        all.add(new Dot(1, 2));
        all.add(new Circle(5, 3, 10));
    }

    public void groupSelected(CompoundGraphic components) {
        CompoundGraphic group = new CompoundGraphic();
        for (Graphic component : components.getChildren()) {
            group.add(component);
            all.remove(component);
            all.add(group);
            all.draw();
        }
    }

    public static void main(String ...args) {
        ImageEditor imageEditor = new ImageEditor();
        imageEditor.load();
        imageEditor.load();
        imageEditor.load();
        imageEditor.load();
        CompoundGraphic components = new CompoundGraphic();
        components.add(new Dot(3, 9));
        components.add(new Dot(17, 29));
        components.add(new Dot(2, 11));
        components.add(new Circle(6, 78, 14));
        components.add(new Circle(71, 37, 22));
        imageEditor.groupSelected(components);
    }
}