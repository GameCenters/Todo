import {
  IsNotEmpty,
  IsString,
  validateOrReject,
} from 'https://deno.land/x/deno_class_validator@v1.0.0/mod.ts'; // * 쓸만한 Class Validator가 없어서 그나마 나아보이는 이 친구들 사용했습니다;;;

export class BaseDTO<T> {
  constructor(value: T) {
    Object.assign(this, value);

    validateOrReject(this);
  }
}

export class CreateBookDTO extends BaseDTO<CreateBookDTO> {
  @IsString()
  @IsNotEmpty()
  title!: string;

  @IsString()
  @IsNotEmpty()
  author!: string;
}
