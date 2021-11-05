package model;

import com.sun.jdi.Value;

import java.util.Objects;

public class ValueSofifaIDDTO {
    public Value value;
    public int sofifaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValueSofifaIDDTO that = (ValueSofifaIDDTO) o;

        return Objects.equals(value, that.value);
    }

    public ValueSofifaIDDTO(Value value) {
        this.value = value;
    }

    public ValueSofifaIDDTO(Value value, int sofifaId) {
        this.value = value;
        this.sofifaId = sofifaId;
    }
}
