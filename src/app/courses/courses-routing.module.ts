import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CoursesComponent } from './courses/courses.component';
import { CreateCoursesComponent } from './create-courses/create-courses.component';
import { UpdateCoursesComponent } from './update-courses/update-courses.component';

const routes: Routes = [
  { path: '', component: CoursesComponent },
  { path: 'create', component: CreateCoursesComponent },
  { path: 'update/:id', component: UpdateCoursesComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CoursesRoutingModule {}
