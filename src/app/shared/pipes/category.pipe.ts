import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'category'
})
export class CategoryPipe implements PipeTransform {

  transform(value: string): string {
    switch(value){
      case 'Frontend': return 'code';
      case 'back-end': return 'computer';
    }
    return 'code';
  }

}
