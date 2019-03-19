public enum GallowSegments {
    SEGMENT_1(1),
    SEGMENT_2(2),
    SEGMENT_3(3),
    SEGMENT_4(4),
    SEGMENT_5(5),
    SEGMENT_6(6);

    int output;

    GallowSegments(int output) {
        this.output = output;
    }

    public int getOutput() {
        return output;
    }

}
