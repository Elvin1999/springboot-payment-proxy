package az.itstep.pp.mapper;


public interface BaseMapper<F,T> {
    T convert(F data);
}
