import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoursesRoutingModule } from './courses-routing.module';
import { CoursesComponent } from './courses/courses.component';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { CreateCoursesComponent } from './create-courses/create-courses.component';
import { MycurrencyPipe } from '../shared/pipes/currency.pipe';


@NgModule({
  declarations: [CoursesComponent, CreateCoursesComponent, MycurrencyPipe],
  imports: [
    CommonModule,
    CoursesRoutingModule,
    AppMaterialModule,
    SharedModule,
  ],
})
export class CoursesModule {}
