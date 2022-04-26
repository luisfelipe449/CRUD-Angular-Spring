import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';
import { Course } from '../model/course';
import { CoursesService } from '../services/courses.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss'],
})
export class CoursesComponent implements OnInit {
  ngOnInit(): void {
    this.courses$ = this.coursesService.list();
  }
  
  courses$: Observable<Course[]>;
  displayedColumns = ['name', 'estoque', 'category', 'total', 'buttons'];

  constructor(
    private coursesService: CoursesService,
    public dialog: MatDialog
  ) {
    this.courses$ = this.coursesService.list().pipe(
      catchError(() => {
        this.onError('Erro ao carregar cursos.');
        return of([]);
      })
    );
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg,
    });
  }

  delete(_id: string) {
    this.coursesService.delete(_id).subscribe(
      () => {
        this.courses$ = this.coursesService.list();
      },
      () => {
        this.onError('Erro ao deletar curso.');
      }
    );
  }

  
}
